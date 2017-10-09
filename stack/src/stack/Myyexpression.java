package stack;


import javax.management.RuntimeErrorException;


/**
 * @author user
 *
 */
public class Myyexpression implements IExpressionEvaluator {
	/**
	 * @author user
	 *
	 */
	 public static final int MAX = 10000000;
	/**
	 * @author user
	 *
	 */
	public int l1 = 0;
	/**
	 * @author user
	 *
	 */
	public int l2 = 0;
	/**
	 * @author user
	 *
	 */
	public int counter = 0;
	/**
	 * @author user
	 *
	 */
	public char[] temp = new char[MAX];

	/**
	 * @author user
	 * @param a
	 *            check operator
	 * @return tag
	 *
	 */
	public boolean isoperator(final char a) {
		if (a == '+' || a == '-' || a == '*' || a == '/') {
			return true;
		}
		return false;
	}

	@Override
public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
	Mystack postfix = new Mystack();
	if (expression.length() == 0 || expression == null) {
		throw new RuntimeErrorException(null);
	}
	for (int j = 0; j < expression.length(); j++) {
		if (expression.charAt(j) == '(') {
			l1++;
		}
		if (expression.charAt(j) == ')') {
			l2++;
		}
	}
	if (l1 != l2) {
		throw new RuntimeErrorException(null);
	}
	for (int j = 1; j < expression.length(); j++) {
		if (isoperator(expression.charAt(j))) {
			if (isoperator(expression.charAt(j - 1))) {
				throw null;
			}
			if (expression.charAt(j - 1) == ' ') {
				Character n = expression.charAt(j - 2);
				if (isoperator(n)) {
					throw null;
				}
			}
		}
	}
	for (int i = 0; i < expression.length(); i++) {
		Character a = expression.charAt(i);
		if (a == '*' && a != ' ') {
			if (i == 0 || i == expression.length() - 1) {
				throw new RuntimeErrorException(null);
			}
			if (postfix.isEmpty()) {
				postfix.push(expression.charAt(i));
			} else {
				Character m = (char) postfix.peek();
				while (m == '/' || m == '*') {
					Character n = (char) postfix.pop();
					temp[counter++] = n;
					if (i != expression.length() - 1) {
						temp[counter++] = ' ';
					}
					if (postfix.isEmpty()) {
						break;
					}
				}
				postfix.push(expression.charAt(i));
			}
		} else if (a == '/' && a != ' ') {
			if (i == 0 || i == expression.length() - 1) {
				throw new RuntimeErrorException(null);
			}
			if (postfix.isEmpty()) {
				postfix.push(expression.charAt(i));
			} else {
				Character q = (char) postfix.peek();
				while (q == '/' || q == '*') {
					temp[counter++] = (char) postfix.pop();
					if (i != expression.length() - 1) {
						temp[counter++] = ' ';
					}
					if (postfix.isEmpty()) {
						break;
					}
					q = (char) postfix.peek();
				}
				postfix.push(expression.charAt(i));
			}
		} else if (a == '+' && a != ' ') {
			if (i == 0 || i == expression.length() - 1) {
				throw new RuntimeErrorException(null);
			}
			if (postfix.isEmpty()) {
				postfix.push(expression.charAt(i));
			} else {
				while ((char) postfix.peek() == '/'
						|| (char) postfix.peek() == '*'
						|| (char) postfix.peek() == '+'
					 || (char) postfix.peek() == '-') {
					temp[counter++] = (char) postfix.pop();
					if (i != expression.length() - 1) {
						temp[counter++] = ' ';
					}
					if (postfix.isEmpty()) {
						break;
					}
				}
				postfix.push(expression.charAt(i));
			}
		} else if (a == '-' && a != ' ') {
			if (i == 0 || i == expression.length() - 1) {
				throw new RuntimeErrorException(null);
			}
			if (postfix.isEmpty()) {
				postfix.push(expression.charAt(i));
			} else {
				while ((char) postfix.peek() == '/'
						|| (char) postfix.peek() == '*'
						|| (char) postfix.peek() == '+'
					 || (char) postfix.peek() == '-') {
					temp[counter++] = (char) postfix.pop();
					if (i != expression.length() - 1) {
						temp[counter++] = ' ';
					}
					if (postfix.isEmpty()) {
						break;
					}
				}
				postfix.push(expression.charAt(i));
			}
		} else if (a == '(' && a != ' ') {
			postfix.push(expression.charAt(i));
		} else if (a == ')' && a != ' ') {
			if (i == 0 || i == expression.length() - 1) {
				throw new RuntimeErrorException(null);
			}
			while ((char) postfix.peek() != '(') {
				temp[counter++] = (char) postfix.pop();
				if (i != expression.length() - 1) {
					temp[counter++] = ' ';
				}
			}
			postfix.pop();
		} else {
			if (expression.charAt(i) != ' ') {
				temp[counter++] = expression.charAt(i);
				temp[counter++] = ' ';
			}
		}
	}
	while (!postfix.isEmpty()) {
		temp[counter++] = (char) postfix.pop();
		if (!postfix.isEmpty()) {
			temp[counter++] = ' ';
		}
	}
	char[] temp2 = new char[counter];
	for (int k = 0; k < counter; k++) {
		temp2[k] = temp[k];
	}
	String post = new String(temp2);
	if (post.length() == 0) {
		throw new RuntimeErrorException(null);
	}
	return post;
}

@Override
public int evaluate(final String expression) {
	// TODO Auto-generated method stub
	Mystack ev = new Mystack();
	for (int i = 0; i < expression.length(); i++) {
		Character x = expression.charAt(i);
		if (x != ' ' && x != '*' && x != '/'
				&& x != '-' && x != '(' && x != ')'
				&& x != '+') {
			if (!Character.isDigit(expression.charAt(i))) {
				throw new RuntimeErrorException(null);
			}
		}
	}
	if (expression.length() == 0 || expression == null) {
		throw new RuntimeErrorException(null);
	}
	int var1;
	int var2;
	int ans = 0;
	for (int i = 0; i < expression.length(); i++) {
		if (expression.charAt(i) != ' ') {
			if (!isoperator(expression.charAt(i))) {
				if (expression.charAt(i + 1) == ' ') {
					int l = expression.charAt(i) - '0';
					ev.push(l);
				} else {
					char[] temp2 = new char[MAX];
					int z = 0;
					while (expression.charAt(i) != ' ') {
						temp2[z] = expression.charAt(i);
						z++;
						i++;
					}
					char[] temp1 = new char[z];
					for (int m = 0; m < z; m++) {
						temp1[m] = temp2[m];
					}
					String num = new String(temp1);
					int r = Integer.valueOf(num);
					ev.push(r);
				}
			} else {
				if (ev.isEmpty()) {
					throw new RuntimeErrorException(null);
				}
				var1 = (Integer) ev.pop();
				if (ev.isEmpty()) {
					throw new RuntimeErrorException(null);
				}
				var2 = (Integer) ev.pop();
				if (expression.charAt(i) == '+') {
					ans = var2 + var1;
				}
				if (expression.charAt(i) == '-') {
					ans = var2 - var1;
				}
				if (expression.charAt(i) == '*') {
					ans = var2 * var1;
				}
				if (expression.charAt(i) == '/') {
					ans = var2 / var1;
				}
				ev.push(ans);
			}
		}
	}
	if (ev.size == 0) {
		throw new RuntimeErrorException(null);
	}
	if (ev.size > 1) {
		return 0;
	} else {
		return (Integer) ev.pop();
	}
}
}

