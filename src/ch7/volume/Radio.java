package ch7.volume;

public class Radio implements Volume {
    private int volumeLevel;

    public Radio() {
    }

    @Override
    public void volumeUp(int level) {
        volumeLevel += level;
        System.out.println(String.format("Volume Up %d level, Current Volume : %d", level, volumeLevel));
    }

    @Override
    public void volumeDown(int level) {
        volumeLevel -= level;
        System.out.println(String.format("Volume Down %d level, Current Volume : %d", level, volumeLevel));
    }
}
