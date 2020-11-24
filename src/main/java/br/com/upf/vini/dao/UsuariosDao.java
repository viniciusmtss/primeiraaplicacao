package br.com.upf.vini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import br.com.upf.vini.connection.PoolDB;
import br.com.upf.vini.dto.CadastrarUsuario;
import br.com.upf.vini.dto.EditarUsuario;
import br.com.upf.vini.model.Usuarios;

@Repository
public class UsuariosDao {

	@Autowired
	private PoolDB poolDB;

	public List<Usuarios> consultarUsuarios() {
		return (List<Usuarios>) poolDB.jdbcIfood().query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("SELECT * from ifood.usuarios");

				// int i = 1;

				// ps.setString(i++, documento);

				return ps;
			}
		}, new ResultSetExtractor<List<Usuarios>>() {
			@Override
			public List<Usuarios> extractData(ResultSet rs) throws SQLException {
				List<Usuarios> results = new ArrayList<Usuarios>();

				while (rs.next()) {
					Usuarios entity = new Usuarios();
					entity.setIdUsuario(rs.getString("ID_USUARIO"));
					entity.setNome(rs.getString("NOME"));

					results.add(entity);
				}

				return (List<Usuarios>) results;
			}
		});

	}

	public void cadastrarUsuario(CadastrarUsuario request) {
		poolDB.jdbcIfood().update(new PreparedStatementCreator() {
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		        PreparedStatement ps = con.prepareStatement("INSERT INTO ifood.usuarios(id_usuario, nome) values (uuid(),?)");
		        
		        int i = 1;
		        
		        ps.setString(i++, request.getNome());
		        
		        return ps;
		    }
		});

	}
	
	public void editarUsuario(String idUsuario, EditarUsuario request) {
		poolDB.jdbcIfood().update(new PreparedStatementCreator() {
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		        PreparedStatement ps = con.prepareStatement("update ifood.usuarios SET nome = ? where id_usuario = ?");
		        
		        int i = 1;
		        
		        ps.setString(i++, request.getNome());
		        ps.setString(i++, idUsuario);
		        
		        return ps;
		    }
		});

	}
	
	public void deletarUsuario(String idUsuario) {
		poolDB.jdbcIfood().update(new PreparedStatementCreator() {
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		        PreparedStatement ps = con.prepareStatement("DELETE FROM ifood.usuarios WHERE id_usuario = ?");
		        
		        int i = 1;
		        
		        ps.setString(i++, idUsuario);
		        
		        return ps;
		    }
		});

	}

}
