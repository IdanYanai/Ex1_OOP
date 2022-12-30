package observer;

/**
 * Class that implements Member interface. It observes the new_usb variable of GroupAdmin.
 */
public class ConcreteMember implements Member{
    UndoableStringBuilder new_usb;

    /**
     * Set the observer to watch the UndoableStringBuilder
     * @param usb - the subject to point to
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        new_usb=usb;
    }

    @Override
    public String toString() {
        return new_usb.toString();
    }
}