package me.viitor.API;

import java.util.Calendar;

public class CalendarioAPI {

	public static enum Calendario {
		Dia, Mes, Ano, DiaDaSemana, Hora, Minuto, Segundo;
	}
	public static int PegarCalendario(Calendario c) { 
		switch (c) {
		case Dia:
			return Calendar.getInstance().get(5);
		case Mes:
			return Calendar.getInstance().get(2) + 1;
		case Ano:
			return Calendar.getInstance().get(1);
		case DiaDaSemana:
			return Calendar.getInstance().get(7);
		case Hora:
			return Calendar.getInstance().get(11);
		case Minuto:
			return Calendar.getInstance().get(12);
		case Segundo:
			return Calendar.getInstance().get(13);
		}
		return 0;
	}
}
