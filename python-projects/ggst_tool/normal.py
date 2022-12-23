POSSIBLE_INPUTS_NORMALS = set(["5P","5K","c.S","f.S","f.SS","f.SSS","5H","5D","2P","2K","2S","2H","2D","6P","6K","6S","6H"])

class Normal:
    __slots__ = ["__input","__damage","__startup","__active","__recovery","on_block","__attributes"] 
    def __init__(self,damage,input,frames,attributes,multi): 
        self.__damage = damage
        self.__input = input
        self.__frames = frames
        self.__attributes = attributes
        self.__multi = multi
    def get_input(self):
        return self.__input
    def get_startup(self):
        if "startup" in self.__frames:
            return self.__frames["startup"]
        raise KeyError
    def get_active(self):
        if "active" in self.__frames:
            return self.__frames["active"]
        raise KeyError
    def get_recovery(self):
        if "recovery" in self.__frames:
            return self.__frames["recovery"]
        raise KeyError
    def get_on_block(self):
        if "on_block" in self.__frames:
            return self.__frames["on_block"]
        raise KeyError

    def get_attributes(self):
        return self.__attributes

