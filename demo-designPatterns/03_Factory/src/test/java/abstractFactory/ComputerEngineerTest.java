package abstractFactory;

import abstractfactory.AbstractFactory;
import abstractfactory.AmdFactory;
import abstractfactory.ComputerEngineer;
import abstractfactory.IntelFactory;
import org.junit.Test;

/**
 * Created by sheng on 2018/10/17.
 */
public class ComputerEngineerTest {

    @Test
    public void testMakeComputer() {
        ComputerEngineer computerEngineer = new ComputerEngineer();
        AbstractFactory factory;

        factory = new IntelFactory();
        computerEngineer.makeComputer(factory);

        factory = new AmdFactory();
        computerEngineer.makeComputer(factory);
    }
}
