package Proyecto;

import java.sql.Date;

public class Ganancia {

	int idGanancia;
	int ventaId;
	Date fecha;
	float ganancia;
	
	public Ganancia(int id,int ventaId, Date fecha, float ganancia) {
		super();
		this.idGanancia = id;
		this.ventaId = ventaId;
		this.fecha = fecha;
		this.ganancia = ganancia;
	}
	
	public void setIdGanancia(int idGanancia) {
		this.idGanancia = idGanancia;
	}
	
	public int getIdGanancia() {
		return idGanancia;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getGanancia() {
		return ganancia;
	}

	public void setGanancia(float ganancia) {
		this.ganancia = ganancia;
	}
	
	
	
	
	
	
}
