using System;
using System.IO;
using System.Runtime.InteropServices;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;
using System.Xml;
using System.IO.MemoryMappedFiles;
namespace ConsoleApplication1
{
    class RoboClient
    {

        public const int PORT = 6060;
        public const string POWER_LIFE_PERCENT = "POWER_LIFE_PERCENT";
        public const string GET_ALL = "<request><get_all_variables></get_all_variables></request>";
        public double DISTANCE;
        public double OFFSETX;
        public double OFFSETY;
        public double test = 42;

        private string response;
        private TcpClient client;
        private NetworkStream stream;
        private byte[] readBuffer = new byte[1024 * 2];
        XmlDocument doc = new XmlDocument();

        public RoboClient(String server)
        {
            client = new TcpClient(server, PORT);
            stream = client.GetStream();
        }

        public void Connect()
        {
            try
            {
                bool done = false;
                while (!done)
                {
                    if (Console.KeyAvailable)
                    {
                        Console.WriteLine("Key pressed");
                        ConsoleKeyInfo k = Console.ReadKey(true);
                        if (k.KeyChar == '1')
                            requestLoadProgram("BlueBall.robo");
                        if (k.KeyChar == '2')
                            requestLoadProgram("RedBall.robo");
                        if (k.KeyChar == '3')
                            requestLoadProgram("ir_target.robo");
                    }
                    DISTANCE = requestVariable("Distance");
                    passToRoboRealm("Distance", 42);
                    Console.WriteLine(DISTANCE);;
                    OFFSETX = (requestVariable("XOffset"));
                    passToRoboRealm("XOffset", 42);
                    Console.WriteLine(OFFSETX);
                    OFFSETY = (requestVariable("YOffset"));
                    passToRoboRealm("YOffset", 42);
                    Console.WriteLine(OFFSETY);
                    passToRoboRealm("Test", test);
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("{0}: {1}", e.GetType().Name, e.Message);
            }
            stream.Close();
            client.Close();
            Console.WriteLine("\n Press Enter to continue...");
            Console.Read();
        }

        public double requestVariable(string varname)
        {
            writeStream(makeVariableRequest(varname));
            response = readStream();
            return parseStream2(response, varname);
        }

        public string extractResponse(string xml)
        {
            doc.LoadXml(xml);
            XmlNodeList elemList = doc.GetElementsByTagName("response");
            if (elemList.Count == 0)
            {
                throw new InvalidTimeZoneException("No <response> element");
            }
            return elemList[0].InnerXml;
        }

        public double parseStream2(string xml, string title)
        {
            doc.LoadXml(xml);
            XmlNodeList elemList = doc.GetElementsByTagName(title);
            if (elemList.Count == 0)
            {
                throw new InvalidTimeZoneException("There was no element");
            }
            else
            {
                if (elemList.Count > 1)
                {
                    Console.Error.WriteLine("More than one element");
                }
                return Convert.ToDouble(elemList[0].InnerXml);
            }
        }

        public void writeStream(string text)
        {
            //writes something turned to bytes
            byte[] buf = System.Text.Encoding.ASCII.GetBytes(text);
            stream.Write(buf, 0, buf.Length);
        }

        public string readStream()
        {
            //reads the stream to the amount of data allocated to buffer
            int bytesRead = stream.Read(readBuffer, 0, readBuffer.Length);
            return System.Text.Encoding.ASCII.GetString(readBuffer, 0, bytesRead);
        }

        public static string makeVariableRequest(string varname)
        {
            //Returns a variable requested
            return "<request><get_variable>" + varname + "</get_variable></request>";
        }

        public bool requestLoadProgram(string filter)
        {
            string request = "<request><load_program>" + filter + "</load_program></request>";
            writeStream(request);
            string response = extractResponse(readStream());
            return response == "ok";
        }
        public string passToRoboRealm(string name, double value)
        {
        return "<request><set_variable><name>" + name + "</name><value>" + value + "</value></set_variable></request>";
        }

        public static void Main(string[] args)
        {
            //"10.46.11.25"
            //"192.168.2.19"
            //"10.2.248.240"
            RoboClient prog = new RoboClient("10.46.11.25");
            Console.WriteLine("You are Connected");
            prog.Connect();
        }
    }
}
