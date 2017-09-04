package alg;

import java.util.BitSet;

public class Reswo
{
	// operations: addition, multiplication, boolean functions (not division or substraction)
	
	private Integer A;
	private Integer B;
	
	private int programCounter = 0;
	
	public FixedSizeBitSet AL = bitSetFromInt(0);
	public FixedSizeBitSet AH = bitSetFromInt(0);
	public FixedSizeBitSet BL = bitSetFromInt(0);
	public FixedSizeBitSet BH = bitSetFromInt(0);
	public FixedSizeBitSet higherAdder = bitSetFromInt(0);
	public FixedSizeBitSet lowerAdder = bitSetFromInt(0);
	public FixedSizeBitSet result = bitSetFromInt(0);
	public FixedSizeBitSet resultSwapped = bitSetFromInt(0);
	public String step = "";
	
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
		FixedSizeBitSet tempAL = AL;
		AL = AH;
		AH = tempAL;
		
		FixedSizeBitSet tempBL = BL;
		BL = BH;
		BH = tempBL;
	}

	public void addHigh()	// dodawanie = XOR
	{
		Integer res = intFromBitSet(AH) + intFromBitSet(BH);
		higherAdder = bitSetFromInt(res);
	}
	
	public void addLow()
	{
		Integer res = intFromBitSet(AL) + intFromBitSet(BL);
		lowerAdder = bitSetFromInt(res);
	}
	
	public void add()
	{
		Integer res = intFromBitSet(lowerAdder) + intFromBitSet(higherAdder);
		result = bitSetFromInt(res);
	}
	
	public void addSwapped()
	{
		Integer res = intFromBitSet(lowerAdder) + intFromBitSet(higherAdder);
		resultSwapped = bitSetFromInt(res);
	}

	public boolean check()
	{
		System.out.println(intFromBitSet(result));
		System.out.println(intFromBitSet(resultSwapped));
		return (result.equals(resultSwapped));
	}

	public void nextStep()
	{
		programCounter++;
		
		switch(programCounter)
		{
			case(1): 
			{
				split();
				step = "Dzielenie liczb na 2 po³ówki";
				break;
			}
			case(2): 
			{
				addHigh();
				step = "Dodawanie wy¿szych po³ówek";
				break;
			}
			case(3): 
			{
				addLow();
				step = "Dodawanie ni¿szych po³ówek";
				break;
			}
			case(4): 
			{
				add();
				step = "Sumowanie dodanych po³ówek";
				break;
			}
			case(6): 
			{
				swapOperands();
				step = "Zamiana pó³ówek miejscami";
				break;
			}
			case(7): 
			{
				addHigh();
				step = "Dodawanie wy¿szych po³ówek";
				break;
			}
			case(8): 
			{
				addLow();
				step = "Dodawanie ni¿szych po³ówek";
				break;
			}
			case(9): 
			{
				addSwapped();
				step = "Sumowanie dodanych zamienionych po³ówek";
				break;
			}
			case(10): 
			{
				boolean equal = check();
				if (equal)
				{
					step = "Sprawdzanie, czy obie zsumowane liczby siê zgadzaj¹: TAK";
				}
				else
				{
					step = "Sprawdzanie, czy obie zsumowane liczby siê zgadzaj¹: NIE";
				}

				break;
			}
			case(11): 
			{
				programCounter = 0;
				break;
			}
		}
	}

	public static FixedSizeBitSet bitSetFromInt(Integer value)
	{
		FixedSizeBitSet bits = new FixedSizeBitSet(32);
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
	
	

	public static Integer intFromBitSet(FixedSizeBitSet bits)
	{
	    int value = 0;
	    for (int i = 0; i < bits.length(); ++i) {
	      value += bits.get(i) ? (1 << i) : 0;
	    }
	    return value;
	  }
}
