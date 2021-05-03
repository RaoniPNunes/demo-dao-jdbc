package model.dao.impl;

import db.DbException;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Sellers;
import java.sql.*;
import model.entities.Department;

public class SellerDaoJDBC implements SellerDao {

    private Connection con;

    public SellerDaoJDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Sellers obj) {
    }

    @Override
    public void update(Sellers obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Sellers findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT seller.*, department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Sellers obj = instantiateSeller(rs, dep);

                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Sellers> findAll() {
        return null;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    private Sellers instantiateSeller(ResultSet rs, Department dep) throws SQLException{
        Sellers obj = new Sellers();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBasesalary(rs.getDouble("BaseSalary"));
        obj.setBirthdate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

}
