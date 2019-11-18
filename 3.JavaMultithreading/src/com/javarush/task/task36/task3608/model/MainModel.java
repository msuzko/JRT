package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.Util;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        if (modelData.getUsers() == null) {
            modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        } else modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        modelData.setUsers(userService.getAllDeletedUsers());
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        User u = userService.deleteUser(id);
        List<User> list = getAllUsers();
        for (User user :
                list) {
            if (user.getId() == id) {
                list.remove(user);
                list.add(u);
                break;
            }
        }
        modelData.setUsers(list);

    }

    @Override
    public void changeUserData(String name, long id, int level) {
        User u = userService.createOrUpdateUser(name,id,level);
        List<User> list = getAllUsers();
        for (User user :
                list) {
            if (user.getId() == id) {
                list.remove(user);
                list.add(u);
                break;
            }
        }
        modelData.setUsers(list);

    }

    private List<User> getAllUsers() {

        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }


}
