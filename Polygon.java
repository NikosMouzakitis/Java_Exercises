public class Polygon {
	
	int x;
	int y;

// Constructors
	
	Polygon() {
		x = 1;
		y = 1;
	}


	Polygon(int x_value, int y_value ) {
		x = x_value;
		y = y_value;
	}


//	getters	
	int get_x() {
		return x;
	}
	
	int get_y() {
		return y;
	}


//	setters
	void set_x(int value) {
		x = value;
	}

	void set_y(int value) {
		y = value;
	}
	
//	Method
	void print_Area() {
		System.out.println(x*y);
	}

}
