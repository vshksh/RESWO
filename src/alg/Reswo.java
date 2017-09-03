package alg;

import java.util.BitSet;

public class Reswo
{
	// operations: addition, multiplication, boolean functions (not division or substraction)
	
	private Integer A;
	private Integer B;
	
	private int programCounter = 0;
	
	public BitSet AL;
	public BitSet AH;
	public BitSet BL;
	public BitSet BH;
	public BitSet higherAdder;
	public BitSet lowerAdder;
	public BitSet result;
	public BitSet resultSwapped;
	
	public Integer getA()
	{
		return A;
	}

	public void setA(Integer a)
	{
		A = a;
	}

	public Integer getB()
	{
		return B;
	}

	public void setB(Integer b)
	{
		B = b;
	}
	
	public void split()
	{
		AL = bitSetFromInt(65535);	// maska
		AL.and(bitSetFromInt(A));
		
		AH = bitSetFromInt(Integer.parseUnsignedInt("4294901760"));
		AH.and(bitSetFromInt(A));
		
		BL = bitSetFromInt(65535);
		BL.and(bitSetFromInt(B));
		
		BH = bitSetFromInt(Integer.parseUnsignedInt("4294901760"));
		BH.and(bitSetFromInt(B));
	}
	
	public void swapOperands()
	{
		BitSet tempAL = AL;
		AL = AH;
		AH = tempAL;
		
		BitSet tempBL = BL;
		BL = BH;
		BH = tempBL;
	}

	public void addHigh()	// dodawanie = XOR
	{
		higherAdder = AH;
		higherAdder.xor(BH);
	}
	
	public void addLow()
	{
		lowerAdder = AL;
		lowerAdder.xor(BL);
	}
	
	public void add()
	{
		result = lowerAdder;
		result.xor(higherAdder);
	}
	
	public void addSwapped()
	{
		resultSwapped = lowerAdder;
		resultSwapped.xor(higherAdder);
	}

	public boolean check()
	{
		return false;
	}

	public void nextStep()
	{
		programCounter++;
		
		switch(programCounter)
		{
			case(1): 
			{
				split();
				break;
			}
			case(2): 
			{
				addHigh();
				break;
			}
			case(3): 
			{
				addLow();
				break;
			}
			case(4): 
			{
				add();
				break;
			}
			case(6): 
			{
				swapOperands();
				break;
			}
			case(7): 
			{
				addHigh();
				break;
			}
			case(8): 
			{
				addLow();
				break;
			}
			case(9): 
			{
				addSwapped();
				break;
			}
			case(10): 
			{
				check();
				break;
			}
			case(11): 
			{
				programCounter = 0;
				break;
			}
		}
	}

	public static BitSet bitSetFromInt(Integer value)
	{
	    BitSet bits = new BitSet();
	    int index = 0;
	    while (value != 0) {
	      if (value % 2 != 0) {
	        bits.set(index);
	      }
	      ++index;
	      value = value >>> 1;
	    }
	    return bits;
	  }

	public static Integer intFromBitSet(BitSet bits)
	{
	    int value = 0;
	    for (int i = 0; i < bits.length(); ++i) {
	      value += bits.get(i) ? (1 << i) : 0;
	    }
	    return value;
	  }
}
