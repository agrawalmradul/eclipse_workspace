

/*
 * Write a function to flatten array of dicts:
example_input: 
[
    {'a':
        {'b':
            {'c':
                {'d':'e'},
             'f':'g'
            }
        }
    }, 
    {'a':{'b':{'c':{'d':{'e':'f'}}}}},
    {'a':'b', 'a1':'b1', 'a2':{'a3':'b3'}}
]

example_output: 
[
    {'a_b_c_d':'e',
      'a_b_f':'g'} 
    {'a_b_c_d_e':'f'},
    {'a':'b', 'a1':'b1', 'a2_a3':'b3'}
]
Map<String, String>
Map<String, Map<String,String>>

You don’t need to parse any input; data will be instantiated for you.
  This is just an example, please think about other possibilities in the input and discuss 
  any assumptions. No need to worry about empty keys or values

Bonus points for using only Java built-in data structures and a good starting point 
is to finalize the method signature.
  
 */

public class GlassdoorInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
