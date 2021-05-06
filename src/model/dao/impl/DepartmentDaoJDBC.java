
package model.dao.impl;

import db.DbException;
import java.sql.*;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
    
    private Connection con;
    
    public DepartmentDaoJDBC(Connection con){
        this.con = con;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("INSERT INTO department "
                                      +"(Id, Name) "
                                      +"VALUES "
                                      +"(?, ?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            
            ps.executeUpdate();
                       
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("UPDATE department "
                                     +"SET Id = ?, Name = ?"
                                     +"WHERE Id = ?");
            
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setInt(3, obj.getId());
            
            ps.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("DELETE FROM department WHERE Id = ? ");
            ps.setInt(1, id);
            
            ps.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Department findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
