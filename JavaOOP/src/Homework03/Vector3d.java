package Homework03;

public class Vector3d {
	private double x;
	private double y;
	private double z;

	public Vector3d() {
		super();
	}

	public Vector3d(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d add(Vector3d vector) {

		return new Vector3d(x + vector.x, y + vector.y, z + vector.z);
	}

	public Vector3d multiScalar(Vector3d vector) {

		return new Vector3d(x * vector.x, y * vector.y, z * vector.z);
	}

	public Vector3d multiVector(Vector3d vector) {
		return new Vector3d(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
	}

	@Override
	public String toString() {
		return "Vector3d [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
