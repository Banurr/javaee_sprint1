package kz.bitlab.techorda.db;

public class Task
{
    private Long id;

    private String name;

    private String description;

    private String deadlineDate;

    private String condition;

    public Task(Long id, String name, String description, String deadlineDate, String condition)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.condition = condition;
    }

    public Task()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDeadlineDate()
    {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate)
    {
        this.deadlineDate = deadlineDate;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }
}
