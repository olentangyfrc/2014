using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;
using System.Xml;
namespace ConsoleApplication1
{
    class RoboClient
    {

        public const int    PORT = 6060;
        public const string POWER_LIFE_PERCENT = "POWER_LIFE_PERCENT";
        public const string GET_ALL = "<request><get_all_variables></get_all_variables></request>";
        public const string DISTANCE = "Distance";

        private string response;
        private TcpClient client;
        private NetworkStream stream;
        private byte[] readBuffer = new byte[1024 * 2];
        XmlDocument doc = new XmlDocument();
        
        public RoboClient(String server)
        {
            client  = new TcpClient(server, PORT);
            stream = client.GetStream();
        }

        public void Connect()
        {
            try
            {                
                bool done = false;
                while (!done)
                {
                    requestVariable(DISTANCE);
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

        public void parseStream(string xml, string title)
        {
            doc.LoadXml(xml);
            XmlNodeList elemList = doc.GetElementsByTagName(title);
            if (elemList.Count == 0)
            {
                Console.Error.WriteLine("No elements!!!");
            }
            else
            {
                if (elemList.Count > 1)
                {
                    Console.Error.WriteLine("More than one element");
                }
                Console.Write(elemList[0].InnerXml);
            }
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

        public static void Main(string[] args)
        {
            RoboClient prog = new RoboClient("10.46.11.25");
            prog.Connect();
        }
    }
}
