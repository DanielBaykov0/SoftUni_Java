public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public int getEndurance() {
        return endurance;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("Endurance should be in range [0..100].");
        }
        this.endurance = endurance;
    }

    public int getSprint() {
        return sprint;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException("Sprint should be in range [0..100].");
        }
        this.sprint = sprint;
    }

    public int getDribble() {
        return dribble;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException("Dribble should be in range [0..100].");
        }
        this.dribble = dribble;
    }

    public int getPassing() {
        return passing;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException("Passing should be in range [0..100].");
        }
        this.passing = passing;
    }

    public int getShooting() {
        return shooting;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException("Shooting should be in range [0..100].");
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.getEndurance() + this.getSprint() + this.getDribble() + this.getPassing() + this.getShooting()) / 5.00;
    }
}
