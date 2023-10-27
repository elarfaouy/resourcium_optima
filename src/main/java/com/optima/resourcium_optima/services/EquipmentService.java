package com.optima.resourcium_optima.services;

import com.optima.resourcium_optima.domain.entities.Equipment;
import com.optima.resourcium_optima.repositories.EquipmentDao;

import java.util.List;

public class EquipmentService {
    private final EquipmentDao equipmentDao = new EquipmentDao();

    public void createEquipment(Equipment equipment) {
        try {
            equipmentDao.createEquipment(equipment);
        } catch (RuntimeException e) {
            throw new RuntimeException("error when create equipment !");
        }
    }

    public Equipment updateEquipment(Equipment equipment) {
        Equipment updated = equipmentDao.updateEquipment(equipment);
        if (updated != null) {
            return updated;
        } else {
            throw new RuntimeException("error when update equipment !.");
        }
    }

    public void deleteEquipment(long equipment_id) {
        try {
            equipmentDao.deleteEquipment(equipment_id);
        } catch (RuntimeException e) {
            throw new RuntimeException("error when delete equipment !");
        }
    }

    public Equipment getEquipmentById(long equipmentId) {
        return equipmentDao.getEquipmentById(equipmentId);
    }

    public List<Equipment> getAllEquipments(String search) {
        search = search != null ? search : "";
        return equipmentDao.getAllEquipments(search);
    }
}
