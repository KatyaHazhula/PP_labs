package com.company.Battle;

import com.company.Droids.Droid;
import com.company.PreparingForGame.PreparingForGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    public static int roundCount;
    private Random random = new Random();
    private ArrayList<Droid> fightingDroids = new ArrayList<>();

    private int indexOfAttacker;
    private int indexOfDefender;
    public static int enlimatedTeam;
    private int accuracyChance;
    PreparingForGame preparingForGame =new PreparingForGame();
    Droid showInfo = new Droid();

    public Battle(Droid ... droid) { //
        roundCount = 1;

        for (Droid droidIterator : droid) {
            Droid fighter = new Droid(droidIterator);
            fightingDroids.add(fighter);
        }
    }

    public void start1vs1Battle() {
        while (preparingForGame.PreparingForGame(fightingDroids)) {
            showInfo.showDroidsInfo(fightingDroids);
            if(fightingDroids.get(0).getIsAbleToMove()==true){
                makeTurn(fightingDroids.get(0), fightingDroids.get(1));
            }
            fightingDroids.get(0).setIsAbleToMove(true);
            System.out.println(" *");

            if(!preparingForGame.PreparingForGame(fightingDroids)) {
                break;
            }

            if(fightingDroids.get(1).getIsAbleToMove()==true){
                makeTurn(fightingDroids.get(1), fightingDroids.get(0));
                System.out.println();
            }
            fightingDroids.get(1).setIsAbleToMove(true);

            roundCount++;

        }

        if(enlimatedTeam == 2) {
            System.out.println(fightingDroids.get(0).getName() + " ЩЕ ЖИВИЙ, ТИ ВИГРАВ!");
        } else {
            System.out.println(fightingDroids.get(1).getName() + "СИЛЬНІШИЙ, ТИ ПРОГРАВ !");
        }
        System.out.println();
    }

    public void start3vs3Battle() {
        while(preparingForGame.PreparingForGame(fightingDroids)) {

            for (int i = 0; i < 3; i++) {
                showInfo.showDroidsInfo(fightingDroids);

                playerTurn();
                makeTurn(fightingDroids.get(indexOfAttacker), fightingDroids.get(indexOfDefender));//,битва учасника 1 команди з учасником 2 ком.
                fightingDroids.get(indexOfAttacker).setIsAbleToMove(false);//нападник більше не може приймати участь
                System.out.println();

                if(!preparingForGame.PreparingForGame(fightingDroids)) {
                    break;
                }

                opponentTurn();
                makeTurn(fightingDroids.get(indexOfAttacker), fightingDroids.get(indexOfDefender));
                fightingDroids.get(indexOfAttacker).setIsAbleToMove(false);
                System.out.println();
            }

            roundCount++;
            //переходимо на наступний раунд та робити всіх able to move
            for (Droid iterator:fightingDroids) {
                if(iterator.getHealth() > 0) {
                    iterator.setIsAbleToMove(true);
                }
            }
        }

        if(enlimatedTeam == 2) {//якщо програвша команда -2, то ви виграли
            System.out.println(" *_-_ ТИ ВИГРАВ! _-_*");
        } else {
            System.out.println(" *_-_ ТИ ПРОГРАВ _-_* ");
        }
        System.out.println();
    }

    private void makeTurn(Droid attacker, Droid defender) {//наносимо удар
        int attack = random.nextInt(attacker.getDamage() + 1);

        accuracyChance = random.nextInt(100);
        int evasionChance = random.nextInt(40);
        //дивимось чи достатньо злості щоб, використати додаткову силу, якщо так тоді збільшуємо attack, якщо не достатньо повертаємо не змінене attack
        attack = checkForWeapon(attacker, defender, attack);
        //якщо рандомно вибрана точність >90 тоді наносимо шкоду +30
        if(accuracyChance > 90) {
            System.out.println(" *КЛАСНО ВМАЗАВ *");
            attack += 30;
        }

        if(isPossibleToHit(attacker, defender, accuracyChance, evasionChance)) {// якщо є можливість вдарити
            makeHit(attacker, defender, attack);
            //якщо здоров'я < 0, то він здох
            if(defender.getHealth() <= 0) {
                defender.setIsAbleToMove(false);
            }
        } else {//// якщо нема можливість вдарити
            System.out.println(" * " + attacker.getName() + " промазав.");
        }
    }

    private int checkForWeapon(Droid attacker, Droid defender, int attack) {
        if(attacker.getRage() >=100) {
            switch(attacker.getTypeOfWeapon()) {
                case 1: {
                    accuracyChance +=40;
                    break;
                }
                case 2: {
                    attacker.gettingHealed(150);
                    break;
                }
                case 3: {
                    attacker.setStatus(1);
                    break;
                }
                case 4: {
                    if(fightingDroids.size()==2){
                        defender.setIsAbleToMove(false);
                    }else{
                        defender.decreasingHealth(200);
                    }
                    break;
                }
                case 5: {
                    attack +=20;
                    break;
                }

            }

            System.out.println(" * " + attacker.getName() + " використовує зброю " + attacker.getTypeOfWeapon());
            attacker.setRage(0);
        }

        return attack;
    }

    private boolean isPossibleToHit(Droid attacker, Droid defender, int accuracyChance, int evasionChance) {
        return accuracyChance >= evasionChance;
    }

    private void makeHit(Droid attacker, Droid defender, int attack) {
        //якщо захисник має перший статус, тобто щит, то удар який він отримує зменшується на 20 %
        if(defender.getStatus() == 1) {
            attack = (int)(attack * 0.2);
            defender.setStatus(0);
        }

        //знімаємо здоров'я
        defender.decreasingHealth(attack);

        defender.increaseRage((int)((double)attack/10 + 10));

        attacker.increaseRage(10);

        System.out.println(" * " + attacker.getName() + " завдає " + attack + " шкоди  " + defender.getName() + "!");
    }

    private void playerTurn() {
        if(canTeamMakeTurn(0)) {
            Scanner in = new Scanner(System.in);

            System.out.print(" Виберіть дроїда,який буде битись -> ");
            indexOfAttacker = in.nextInt() - 1;

            while(fightingDroids.get(indexOfAttacker).getIsAbleToMove() == false) {
                System.out.print("Неможливо вибрати його. Виберіть іншого -> ");
                indexOfAttacker = in.nextInt() - 1;
            }

            System.out.print(" Виберіть дроїда,який буде захищатись -> ");
            indexOfDefender = in.nextInt() + fightingDroids.size()/2 - 1;

            while(fightingDroids.get(indexOfAttacker).getHealth() <= 0) {
                System.out.print(" Дроїд здох. Виберіть іншого -> ");
                indexOfDefender = in.nextInt() + fightingDroids.size()/2 - 1;
            }
        }
    }

    private void opponentTurn() {
        if(canTeamMakeTurn(1)) {
            indexOfAttacker = random.nextInt(fightingDroids.size()/2) + fightingDroids.size()/2;//вибираємо рандомного атакера з 2 команди

           // if(canTeamMakeTurn(1)) {
                while(fightingDroids.get(indexOfAttacker).getIsAbleToMove() == false) {//якщо unable to move вибираємо іншого атакера
                    indexOfAttacker = random.nextInt(fightingDroids.size()/2) + fightingDroids.size()/2;
                }
                int minHP = 0;

                for (int i = 0, lastDroid = fightingDroids.size()/2; i < lastDroid; i++) {
                    if((minHP == 0 | fightingDroids.get(i).getHealth() < minHP)&& fightingDroids.get(i).getHealth() > 0) {//minHP==0 для першого входження
                        //вибирає того в кого найменше хп і якщо він живий.(завжди вибирає того в кого найменше щоб скорше добити)
                        indexOfDefender = i;
                        minHP = fightingDroids.get(i).getHealth();
                    }
                }
           // }
        }
    }

    private boolean canTeamMakeTurn(int teamNum) {//перевярє чи команда може битись
        int countOfUnableDroids = 0;
        int teamFirstMember = 0;
        int teamLastMember = fightingDroids.size() / 2;

        //якщо це є 2 команда, то переприсвоюємо першого та останнього гравця. Якщо ж це 1 команда, то пропускаємо if
        if(teamNum == 1) {
            teamFirstMember = fightingDroids.size() / 2;
            teamLastMember = teamFirstMember + fightingDroids.size() / 2;
        }

        while(teamFirstMember < teamLastMember) {
            if(fightingDroids.get(teamFirstMember).getIsAbleToMove() == false) {
                countOfUnableDroids++;
            }

            teamFirstMember++;
        }

        return countOfUnableDroids != fightingDroids.size() / 2;
    }


}