package es.iespuertodelacruz.rl.entities;

public class Operador {
	
	int id;
	String nick;
	String password;
	
	public Operador(int id, String nick, String password) {
		super();
		this.id = id;
		this.nick = nick;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
