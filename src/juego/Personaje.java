package juego;

import javax.swing.JOptionPane;

public class Personaje {

    public double defensaP = 10;
    public int hp = 0;

    public int cantidad = 2;
    long lastAttack = 0;

    Personaje() {
        salud();
        defensa();

    }

    public static int getRandomInteger(int maximo, int minimo) {
        return ((int) (Math.random() * (maximo - minimo))) + minimo;
    }

    public int salud() {
        this.hp = getRandomInteger(150, 100);
        return this.hp;
    }

    public void curar(Personaje personaje) {
        double sanar1 = Math.random() * 100;
        int sanar = (int) Math.round(sanar1);
        personaje.hp += sanar;
        personaje.cantidad--;

    }

    public void ataque(Personaje enemigo) {
        double ataque = getRandomInteger(20, 10);

        double chanceCritico = getRandomInteger(10, 2);

        double daño = (ataque + (ataque * Math.random()) - enemigo.defensa());
        int dañoEntero = (int) Math.round(daño);
        double critico = chanceCritico * Math.random();
        if (dañoEntero <= 0) {
            enemigo.hp = enemigo.hp;
            System.out.println("Daño: 0");
        } else {
            if (critico > 5.0) {
                dañoEntero *= 2;
                System.out.println("Critico!");
                enemigo.hp = enemigo.hp - dañoEntero;
                System.out.println("Daño: " + dañoEntero);

            } else {
                enemigo.hp = enemigo.hp - dañoEntero;
            }
            System.out.println("No critico");
            System.out.println("Daño: " + dañoEntero);

        }
    }

    public void ataqueDoble(Personaje heroe, Personaje enemigo) {

        if (cooldown() == true) {

            double ataque = getRandomInteger(20, 10);

            double chanceCritico = getRandomInteger(10, 2);

            double daño = ataque + (ataque * 2 * Math.random());
            int dañoEntero = (int) Math.round(daño);
            double critico = chanceCritico * Math.random();
            if (critico > 5.0) {
                dañoEntero *= 2;
                System.out.println("DOBLE CRITICO!");
                enemigo.hp = enemigo.hp - dañoEntero;

            } else {
                enemigo.hp = enemigo.hp - dañoEntero;
            }
            System.out.println("Golpe doble!");
        } else {
            System.out.println("Habilidad en recarga: ");
        }

    }

    public boolean cooldown() {

        long cooldownTime = 10000; // 10000 milliseconds
        long time = System.currentTimeMillis();
        if (time > lastAttack + cooldownTime) {
            lastAttack = time;
            return true;
        } else {
            System.out.println("Tiempo: " + (10 - (time - lastAttack) / 1000) + " segundos");
        }
        return false;
    }

    public static void dañoAtaque(Personaje heroe, Personaje enemigo) {
        heroe.ataque(enemigo);

    }

    public static void sanar(Personaje personaje) {
        personaje.curar(personaje);

    }

    public int defensa() {

        double defensa = defensaP + (defensaP * Math.random());
        int defensaTotal = (int) Math.round(defensa);
        return defensaTotal;
    }

    public static String crearPersonaje() {
        String name = JOptionPane.showInputDialog(null, "¿Cual será tu nombre?", "Crear personaje", -1);
        return name;
    }

}
