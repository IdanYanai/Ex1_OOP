package observer;

import java.util.ArrayList;

/**
 * Class that implements Sender to notify the observers when a change is made to the String
 */
public class GroupAdmin implements Sender {
    public ArrayList<Member> observers = new ArrayList<>(); // The list that holds the observers
    public UndoableStringBuilder new_usb = new UndoableStringBuilder(); // The subject of the observers.

    /**
     * Adds a new member to observers list, and updates its pointer to the subject (new_usb).
     * @param obj the member to add.
     */
    @Override
    public void register(Member obj) {
        obj.update(new_usb);
        observers.add(obj);
    }

    /**
     * Removes a member from the observers list.
     * @param obj the member to remove.
     */
    @Override
    public void unregister(Member obj) {
        observers.remove(obj);
    }

    /**
     * Uses the insert function of new_usb (which insert a substring into the string)
     * and notifies the observers about the change.
     * @param offset where to insert the substring.
     * @param obj substring to append.
     */
    @Override
    public void insert(int offset, String obj) {
        new_usb.insert(offset,obj);
        notify_observers();
    }

    /**
     * Uses the append function of new_usb (which appends a substring to the end of the string)
     * and notifies the observers about the change.
     * @param obj the substring to append.
     */
    @Override
    public void append(String obj) {
        new_usb.append(obj);
        notify_observers();
    }

    /**
     * Uses the delete function of new_usb (which deletes a part of the string)
     * and notifies the observers about the change.
     * @param start start index.
     * @param end end index.
     */
    @Override
    public void delete(int start, int end) {
        new_usb.delete(start, end);
        notify_observers();
    }

    /**
     * Uses the undo function of new_usb (which undoes the last change to the string)
     * and notifies the observers about the change.
     */
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