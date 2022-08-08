package dto;

import java.util.List;

public class InputFileDataDto {
    private List criteria;
    private String startDate;
    private String endDate;

    public List getCriteria() {
        return criteria;
    }

    public void setCriteria(List criteria) {
        this.criteria = criteria;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
