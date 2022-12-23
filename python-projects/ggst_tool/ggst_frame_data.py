from urllib.request import urlopen
import re
from character import *
from normal import *

def main():
    working_url = URL + "Sol_Badguy"
    page = urlopen(working_url)
    html_bytes = page.read()
    html = html_bytes.decode("utf-8")
    buttons = re.findall('<big><span id="clr-text" class="colorful-text" style="--data-color:1">5P</span></big>',html)


    print(buttons)

if __name__ == "__main__":
    main()