package com.optima.resourcium_optima.domain.entities;

import com.optima.resourcium_optima.domain.enums.IssueStatus;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date reportedDate;
    private IssueStatus issueStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public Issue() {
    }

    public Issue(Date reportedDate, IssueStatus issueStatus, User user, Equipment equipment) {
        this.reportedDate = reportedDate;
        this.issueStatus = issueStatus;
        this.user = user;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getStatusCssClass() {
        switch (issueStatus) {
            case RESOLVED:
                return "bg-gradient-to-tl from-green-600 to-lime-400";
            case IN_PROGRESS:
                return "bg-gradient-to-tl from-red-600 to-yellow-400";
            case REJECTED:
                return "bg-gradient-to-tl from-red-600 to-red-400";
            default:
                return "bg-gradient-to-tl from-gray-400 to-gray-200";
        }
    }
}
