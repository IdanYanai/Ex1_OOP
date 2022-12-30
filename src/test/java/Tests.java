import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class
 */
public class Tests
{
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    GroupAdmin ga;

    /**
     * Initialize the GroupAdmin and members before testing.
     */
    @BeforeEach
    public void initialize() {
        ga = new GroupAdmin();
        for(int i=0;i<3;i++)
            ga.register(new ConcreteMember());
    }

    /**
     * Test if the observers work and check memory size after each check.
     */
    @Test
    public void test()
    {
        // After running the test we can see that after each check the memory goes up by 72
        // We used one function on 3 members so each one is taking 72/3=24 more memory.

        logger.info(() -> "----------  Info ----------\n" + JvmUtilities.jvmInfo());

        logger.info(() -> "----------  Before ----------\n" + JvmUtilities.objectFootprint(ga));

        ga.append("test");
        for(Member m : ga.observers)
            assertEquals("test" , m.toString());
        logger.info(() -> "Size after append" + JvmUtilities.objectTotalSize(ga) + "\n");

        ga.delete(2,4);
        for(Member m : ga.observers)
            assertEquals("te" , m.toString());
        logger.info(() -> "Size after delete" + JvmUtilities.objectTotalSize(ga) + "\n");

        ga.insert(2, "st");
        for(Member m : ga.observers)
            assertEquals("test" , m.toString());
        logger.info(() -> "Size after insert" + JvmUtilities.objectTotalSize(ga) + "\n");

        ga.undo();
        for(Member m : ga.observers)
            assertEquals("te" , m.toString());
        logger.info(() -> "Size after undo" + JvmUtilities.objectTotalSize(ga) + "\n");

        logger.info(() -> "----------  Before ----------\n" + JvmUtilities.objectFootprint(ga));
    }
}