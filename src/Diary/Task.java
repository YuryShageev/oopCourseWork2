package Diary;

import java.time.LocalDateTime;

public class Task {

    private String heading;
    private String description;
    private String type;
    private ConstantInfo repetition;
    private LocalDateTime localDateTime;
    private Integer id = 0;

    public Task(String heading, String description, String type, ConstantInfo repetition) {

        this.heading = validateLines(heading);
        this.description = validateLines(description);
        this.type = validateLines(type);
        this.repetition = repetition;
        this.localDateTime = LocalDateTime.now();
        ++id;
    }


    //Getters and Setters


    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ConstantInfo getRepetition() {
        return repetition;
    }

    public void setRepetition(ConstantInfo repetition) {
        this.repetition = repetition;
    }

    //Validators

    public String validateLines(String value) {
        if (value != null || !value.isBlank() || !value.isEmpty()) {
            return value;
        } else {
            throw new UnsupportedOperationException("Не все данные заполнены");
        }
    }

    @Override
    public String toString() {
        return "Задача: " + heading + ", для этого нужно: " + description + ", тип задачи: " +
                type + ", как часто повторяется: " + repetition.getRepeatIndex() +
                ", дата создания задачи: " + localDateTime;
    }
}
