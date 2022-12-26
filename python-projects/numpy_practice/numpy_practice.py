import numpy as np

def main():
    array1 = np.array([1,2,3])
    array2 = np.array([[1,2],[3,4]])
    array3 = np.array([[[1,2],[3,4]],[[5,6],[7,8]]],dtype='float16')
    print(array1,array2)
    print(array1.ndim,array2.ndim,array3.ndim) # number of nested lists/arrays in an array ex: 1(d) 2(d) 3(d)
    print(array1.shape,array2.shape,array3.shape) # dimensions of the array ex: (cols,rows,height) (3,) (2,2) (2,2,2)
    print(array1.dtype,array2.dtype,array3.dtype) # type of each item in the array, first is type 2nd is number of bits per item ex: int32 int32 float 16;  
    print(array1.itemsize,array2.itemsize,array3.itemsize) # number of bytes (8 bits) in each item in the array ex: 4 4 2
    print(array1.size,array2.size,array3.size) # number of elements in the entire array included nested dimesnions ex: 3 4 8
    list1 = [1,2,3]
    print(list1.__bytes__)
if __name__ == "__main__":
    main()