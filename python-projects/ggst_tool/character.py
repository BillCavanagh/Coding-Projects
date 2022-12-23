from urllib.request import urlopen
URL = "https://www.dustloop.com/w/GGST/"
CHARACTER_NAMES = ["Testament","Jack-O"]
class Character:
    __slots__ = ["__normals_dict","__name"]
    def __init__(self):
        self.__normals_dict == {}
        self.__name = ""
    def init_normals(self):
        working_url = URL + self.__name
        page = urlopen(working_url)
        html_bytes = page.read()

    def get_normals(self):
        return self.__normals_dict
    def get_name(self):
        return self.__name