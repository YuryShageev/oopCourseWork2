package Diary;

public enum ConstantInfo {
    SINGLE("Однократно"),
    DAILY("Ежедневно"),
    WEEKLY("Еженедельно"),
    MONTHLY("Ежемесячно"),
    ANNUALLY("Ежегодно");

    private String repeatIndex;

    ConstantInfo(String repeatIndex) {
        this.repeatIndex = repeatIndex;
    }

    public String getRepeatIndex() {
        return repeatIndex;
    }

}
