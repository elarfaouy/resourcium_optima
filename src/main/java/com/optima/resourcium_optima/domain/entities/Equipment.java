package com.optima.resourcium_optima.domain.entities;

import com.optima.resourcium_optima.domain.enums.EquipmentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private EquipmentStatus equipmentStatus;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Equipment() {
    }

    public Equipment(String name, String type, EquipmentStatus equipmentStatus, Department department) {
        this.name = name;
        this.type = type;
        this.equipmentStatus = equipmentStatus;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EquipmentStatus getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(EquipmentStatus equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatusCssClass() {
        switch (equipmentStatus) {
            case AVAILABLE:
                return "bg-gradient-to-tl from-green-600 to-lime-400";
            case IN_USE:
                return "bg-gradient-to-tl from-blue-600 to-cyan-400";
            case MAINTENANCE:
                return "bg-gradient-to-tl from-red-600 to-yellow-400";
            case OUT_SERVICE:
                return "bg-gradient-to-tl from-gray-600 to-gray-400";
            default:
                return "bg-gradient-to-tl from-gray-400 to-gray-200";
        }
    }
}
