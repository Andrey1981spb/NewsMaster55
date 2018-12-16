package ru.spb;

import java.util.List;

public class PushModifier {

    UserDAO userDAO = new UserDAO();

    public PushModifier() {

    }

    public Pushdata findPushdata(long id) {
        return userDAO.findById(id);
    }

    public void savePushdata(Pushdata pushdata) {
        userDAO.save(pushdata);
    }

    public void deletePushdata(Pushdata pushdata) {
        userDAO.delete(pushdata);
    }

    public void updatePushdata(Pushdata pushdata) {
        userDAO.update(pushdata);
    }

    public List<Pushdata> findAllPushdata() {
        return userDAO.findAll();
    }

}
