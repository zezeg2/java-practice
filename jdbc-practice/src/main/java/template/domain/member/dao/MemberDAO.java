package template.domain.member.dao;

import template.connection.MyConnection;
import template.domain.member.dtos.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {

    private final Connection con;

    public MemberDAO() {
        con = MyConnection.getConnection();
    }

    public int insert(MemberDTO dto) {
        String sql = "INSERT INTO member (id, pw, name, email, phone, address, indate) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pt = con.prepareStatement(sql)) {
            pt.setString(1,dto.getId());
            pt.setString(2,dto.getPw());
            pt.setString(3,dto.getName());
            pt.setString(4,dto.getEmail());
            pt.setString(5,dto.getPhone());
            pt.setString(6,dto.getAddress());
            pt.setString(7,dto.getIndate());
            System.out.println("회원 등록 완료");
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
