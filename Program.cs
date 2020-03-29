using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace MorseCode
{
    class Program
    {
        static Dictionary<char, string> CharToMorseCode;
        static void Main(string[] args)
        {
            
            Codes();
             string inputi;
            Console.Write("Write your Plaintext here: ");
            inputi = Console.ReadLine().ToLower();
            while (!(string.IsNullOrEmpty(inputi)))
            {
                try
                {
                    string encoding = Encoded(inputi);
                    string Decoding = Decoded(encoding);

                    Console.WriteLine("Your Encoded message is: " + encoding);
                    Console.WriteLine("Your Decoded message is : " + Decoding);
                    Console.ReadKey();
                }
                catch (Exception)
                {
                    Console.WriteLine("Error:This message is not Valid! ");
                }
            }

        }
        private static void Codes()
        {
           
            CharToMorseCode = new Dictionary<char, string>()
        {

            {'a', ".-"},
            {'b', "-..."},
            {'c', "-.-."},
            {'d', "-.."},
            {'e', "."},
            {'f', "..-."},
            {'g', "--."},
            {'h', "...."},
            {'i', ".."},
            {'j', ".---"},
            {'k', "-.-"},
            {'l', ".-.."},
            {'m', "--"},
            {'n', "-."},
            {'o', "---"},
            {'p', ".--."},
            {'q', "--.-"},
            {'r', ".-."},
            {'s', "..."},
            {'t', "-"},
            {'u', "..-"},
            {'v', "...-"},
            {'w', ".--"},
            {'x', "-..-"},
            {'y', "-.--"},
            {'z', "--.."},

            {'0', "-----"},
            {'1', ".----"},
            {'2', "..---"},
            {'3', "...--"},
            {'4', "....-"},
            {'5', "....."},
            {'6', "-...."},
            {'7', "--..."},
            {'8', "---.."},
            {'9', "----."},

        };
        }
        private static string Encoded(string inputi)
        {

            StringBuilder Coding = new StringBuilder();
            string[] inputArray = inputi.Split(" / ");
            foreach (string a in inputArray)
            {
                foreach (char c in a)
                {
                    if (CharToMorseCode.ContainsKey(c))
                    {
                        Coding.Append(CharToMorseCode[c] + " ");
                        foreach (char b in CharToMorseCode[c])
                        {
                            if (b == '.')
                            {
                                Console.Beep(600, 100);
                                Console.Write(".");
                            }
                            else
                            {
                                Console.Write("-");
                                Console.Beep(600, 300);
                            }
                            System.Threading.Thread.Sleep(300);
                        }
                        System.Threading.Thread.Sleep(300);
                        
                    }
                    else if (c == ' ')
                    {
                        Coding.Append(" / ");
                    }
                    else
                    {
                        Coding.Append(c + " ");
                    }
                    System.Threading.Thread.Sleep(300);
                }
                System.Threading.Thread.Sleep(300);
            }
            Console.WriteLine();
            return Coding.ToString();
        }
      public static string Decoded(string inputi)
        {
            StringBuilder finaloutput = new StringBuilder();
            string[] inputArray = Regex.Split(inputi, " / ");
            foreach (string a in inputArray)
            {
                string[] morseArray = Regex.Split(a, " ");
                foreach (string c in morseArray)
                {
                    finaloutput.Append(CharToMorseCode.FirstOrDefault(b => b.Value == c).Key);
                }

            }
            return finaloutput.ToString();
        }
    }
}
