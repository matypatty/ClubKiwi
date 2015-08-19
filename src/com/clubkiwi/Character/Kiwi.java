package com.clubkiwi.Character;

import java.util.Random;

/**
 * Kiwi character class.
 */
public class Kiwi
{
    //Attributes
    private String name;
    private double health, money;

    //Additional stats
    private double strength, speed, flight, swag;

    //Needs
    private double hunger, mood, energy;

    //Client things (not synced to server)
    private boolean sleeping;

    public Kiwi(String name, double health, double money, double strength, double speed, double flight, double swag, double hunger, double mood, double energy)
    {
        this.name = name;
        this.health = health;
        this.money = money;
        this.strength = strength;
        this.speed = speed;
        this.flight = flight;
        this.swag = swag;
        this.hunger = hunger;
        this.mood = mood;
        this.energy = energy;

        //Client defaults
        this.sleeping = true;
    }

    public void updateKiwi(String name, double health, double money, double strength, double speed, double flight, double swag, double hunger, double mood, double energy)
    {
        this.name = name;
        this.health = health;
        this.money = money;
        this.strength = strength;
        this.speed = speed;
        this.flight = flight;
        this.swag = swag;
        this.hunger = hunger;
        this.mood = mood;
        this.energy = energy;
    }

    //region Getters
    public String getName()
    {
        return name;
    }

    public double getHealth()
    {
        return health;
    }

    public double getMoney()
    {
        return money;
    }

    public double getSwag()
    {
        return swag;
    }

    public double getStrength()
    {
        return strength;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getFlight()
    {
        return flight;
    }

    public double getHunger()
    {
        return hunger;
    }

    public double getMood()
    {
        return mood;
    }

    public double getEnergy()
    {
        return energy;
    }

    public boolean isSleeping()
    {
        return sleeping;
    }
    //endregion

    //region Setters
    public void setHealth(double health)
    {
        if (health < 0)
            throw new IllegalArgumentException("Health cannot be set smaller than 0");

        this.health = health;
    }

    public void setMoney(double money)
    {
        if (money < 0)
            throw new IllegalArgumentException("Money cannot be set smaller than 0");

        if (money < 100000)
            throw new IllegalArgumentException("Money cannot be set larger than 100000");

        this.money = money;
    }

    public void setSwag(double swag)
    {
        this.swag = swag;
    }

    public void setStrength(double strength)
    {
        if (strength < 0)
            throw new IllegalArgumentException("Strength cannot be set smaller than 0");
        this.strength = strength;
    }

    public void setSpeed(double speed)
    {
        if (speed < 0)
            throw new IllegalArgumentException("Speed cannot be set smaller than 0");
        this.speed = speed;
    }

    public void setFlight(double flight)
    {
        if (flight < 0)
            throw new IllegalArgumentException("Flight cannot be set smaller than 0");
        this.flight = flight;
    }

    public void setHunger(double hunger)
    {
        if (hunger < 0)
            throw new IllegalArgumentException("Hunger cannot be set smaller than 0");
        this.hunger = hunger;
    }

    public void setMood(double mood)
    {
        if (mood < 0)
            throw new IllegalArgumentException("Mood cannot be set smaller than 0");
        this.mood = mood;
    }

    public void setEnergy(double energy)
    {
        if (energy < 0)
            throw new IllegalArgumentException("Energy cannot be set smaller than 0");
        this.energy = energy;
    }

    public void setSleeping(boolean sleeping)
    {
        this.sleeping = sleeping;
    }
    //endregion


    //String things
    @Override
    public String toString()
    {
        return getKiwiGraphic() + "\n" + name + ": " +
                "\nhealth=" + getPercent(getHealth(), 5) +
                // "\nmoney=" + money +
                // ", strength=" + strength +
                // ", speed=" + speed +
                //  ", flight=" + flight +
                //  ", swag=" + swag +
                "\nhunger=" + getPercent(getHunger(), 5) +
                "\nmood  =" + getPercent(getMood(), 5) +
                "\nenergy=" + getPercent(getEnergy(), 5);
    }

    //Makes a nice [===] percent bar used in printing.
    private String getPercent(double value, int scale)
    {
        String temp = "[";
        for (int i = 0; i < 100; i += scale)
        {
            if (i < value)
                temp += "=";
            else
                temp += " ";
        }

        temp += "] " + value + "%";

        return temp;
    }

    private String getKiwiGraphic()
    {
        //Random int for animation.
        Random rnd = new Random();
        int rndint = rnd.nextInt(2);

        if(health <= 0)
        {
            //Tombstone for dead kiwi.
            return "       _____\n" +
                    "     //  +  \\\n" +
                    "    ||  RIP  |\n" +
                    "    ||       |\n" +
                    "    ||       |      " + getName() + "\n" +
                    "   \\||/\\/\\//\\|/";
        }

        if (sleeping)
        {
            //Sleeping has closed eye and zzz.
            return "   _ __ zzz\n" +
                    " /  (->-\n" +
                    " \\__/\n" +
                    "  L\\_";
        }

        if (mood > 80)
        {
            //Left-Right facing animation style if happy.
            if (rndint > 0)
            {
                return "   __ _\n" +
                        "  /  ('>-\n" +
                        "  \\__/\n" +
                        "   L\\_";
            }
            else
            {
                return "   _ __\n" +
                        " -<')  \\\n" +
                        "    \\__/\n" +
                        "    _/I";
            }
        }

        return "pissed off lol";
    }
}
