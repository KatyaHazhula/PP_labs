package com.company.Battle;

import com.company.Droids.*;
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

    PreparingForGame preparingForGame =new PreparingForGame();

    public Battle(Droid... droid) { //
        roundCount = 1;

        for (Droid droidIterator : droid) {

            Droid fighter= null;
            String name = droidIterator.getName();
            int health = droidIterator.getHealth();
            int damage = droidIterator.getDamage();

            if (droidIterator instanceof DroidKnight) {
                fighter = new DroidKnight(name, health, damage);
            } else if (droidIterator instanceof DroidFairy) {
                fighter = new DroidFairy(name, health, damage);
            } else if (droidIterator instanceof ArmoredDroid) {
                fighter = new ArmoredDroid(name, health, damage);
            }else if (droidIterator instanceof DroidVedma) {
                fighter = new DroidVedma(name, health, damage);
            }else if (droidIterator instanceof DangerousDroid) {
                fighter = new DangerousDroid(name, health, damage);
            }
            fightingDroids.add(fighter);
        }

    }


    public void start1vs1Battle() {
        while (preparingForGame.PreparingForGame(fightingDroids)) {
            fightingDroids.get(0).showDroidsInfo(fightingDroids);

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
            System.out.println(fightingDroids.get(1).getName() + " СИЛЬНІШИЙ, ТИ ПРОГРАВ !");
        }
        System.out.println();
    }

    public void start3vs3Battle() {
        while(preparingForGame.PreparingForGame(fightingDroids)) {

            for (int i = 0; i < 3; i++) {
                fightingDroids.get(0).showDroidsInfo(fightingDroids);


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
        attacker.setAttack(random.nextInt(attacker.getDamage() + 1));

        attacker.setAccuracyChance(random.nextInt(100));
        int evasionChance = random.nextInt(40);
        //дивимось чи достатньо злості щоб, використати додаткову силу

        checkForWeapon(attacker, defender);

        //якщо рандомно вибрана точність >90 тоді наносимо шкоду +30
        if(attacker.getAccuracyChance() > 90) {
            System.out.println(" *КЛАСНО ВМАЗАВ *");
            attacker.setAttack(attacker.getAttack()+30);
        }

        if(isPossibleToHit(attacker, defender, attacker.getAccuracyChance(), evasionChance)) {// якщо є можливість вдарити
            makeHit(attacker, defender, attacker.getAttack());
            //якщо здоров'я < 0, то він здох
            if(defender.getHealth() <= 0) {
                defender.setIsAbleToMove(false);
            }
        } else {// якщо нема можливість вдарити, дроїд лох
            System.out.println(" * " + attacker.getName() + " промазав.");
        }
    }

    private void checkForWeapon(Droid attacker, Droid defender) {
        if(attacker.getRage() >=100 && !(attacker instanceof ArmoredDroid)) {

            if (attacker instanceof DroidKnight) {
                attacker.usePower();
            } else if (attacker instanceof DroidFairy) {
                attacker.usePower();
            }else if (attacker instanceof DroidVedma) {
                attacker.usePower(defender, fightingDroids);
            }else if (attacker instanceof DangerousDroid) {
                attacker.usePower();
            }

            System.out.println(" * " + attacker.getName() + " використовує зброю " );
            attacker.setRage(0);
        }

    }

    private boolean isPossibleToHit(Droid attacker, Droid defender, int accuracyChance, int evasionChance) {
        return accuracyChance >= evasionChance;
    }

    private void makeHit(Droid attacker, Droid defender, int attack) {

        if(defender instanceof ArmoredDroid && defender.getRage()>=100) {
            defender.usePower(attacker);
            defender.setRage(0);
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