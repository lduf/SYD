package rpc;

public class Argument {
	/* Attributs */
	String name;
	String type;

	public Argument(String n, String t) {
		// TODO faire le traitement sur les paramètres pour dégager nom de package et tout le tralala

		this.name = n;
		this.type = t;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	@Override
    public String toString() {
        return String.format(this.type + " " + this.name);
    }
}