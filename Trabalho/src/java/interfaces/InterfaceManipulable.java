package interfaces;

import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public interface InterfaceManipulable {

    abstract void save() throws SQLException, ClassNotFoundException;

    abstract void update() throws SQLException, ClassNotFoundException;

    abstract void find(int codigo) throws SQLException, ClassNotFoundException;

    abstract void delete() throws SQLException, ClassNotFoundException;

}
