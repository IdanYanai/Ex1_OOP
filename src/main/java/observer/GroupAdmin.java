package observer;

import java.util.ArrayList;

/**
 * Class that implements Sender to notify the observers when a change is made to the String
 */
public class GroupAdmin implements Sender {
    public ArrayList<Member> observers = new ArrayList<>();;
    public UndoableStringBuilder new_usb = new UndoableStringBuilder();

    // For each override method we

    @Override
    public void register(Member obj) {
        obj.update(new_usb);
        observers.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        observers.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        new_usb.insert(offset,obj);
        notify_observers();
    }

    @Override
    public void append(String obj) {
        new_usb.append(obj);
        notify_observers();
    }

    @Override
    public void delete(int start, int end) {
        new_usb.delete(start, end);
        notify_observers();
    }

    @Override
    public void undo() {
        new_usb.undo();
        notify_observers();
    }

    /**
     * Go over all observers and update them
     */
    public void notify_observers(){
        for(Member obj:observers){
            obj.update(new_usb);
        }
    }

    public String toString() {
        return new_usb.toString();
    }
}