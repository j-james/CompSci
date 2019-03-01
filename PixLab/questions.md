# Picture Lab - Questions

## A1: Introduction to digital pictures and color
1) How many bits does it take to represent the values from 0 to 255?
   1) It takes 8 bits. 2^8 = 256.
2) How many bytes does it take to represent a color in the RGB color model?
   1) It takes three bytes. Three sets of 0-255 values.
3) How many pixels are in a picture that is 640 pixels wide and 480 pixels high?
   1) 307200 pixels. 640 * 480.

## A2: Picking a color
1) How can you make pink?
   1) [200, 80, 240]
2) How can you make yellow?
   1) [200, 230, 0]
3) How can you make purple?
   1) [130, 50, 190]
4) How can you make white?
   1) [255, 255, 255]
5) How can you make dark gray?
   1) [45, 45, 45]

## A3: Exploring a picture
1) What is the row index for the top left corner of the picture?
   1) The row index is zero.
2) What is the column index for the top left corner of the picture?
   1) The column index is zero.
3) The width of this picture is 640. What is the rightmost column index?
   1) The rightmost column index is 639.
4) The height of this picture is 480. What is the bottommost row index?
   1) The bottommost row index is 479.
5) Does the row index increase from left to right or top to bottom?
   1) The row index increases from top to bottom.
6) Does the column index increase from left to right or top to bottom?
   1) The column index increases from left to right.
7) Set the zoom to 500%. Can you see squares of color? This is called pixelation.
   Pixelation means displaying a picture so magnified that the individual pixels
   look like small squares.
   1) Cool.

## A4: Two-dimensional arrays in Java
No questions.

## A5: Modifying a picture
1) Open `Picture.java` and look for the method `getPixels2D`. Is it there?
   1) No.
2) Open `SimplePicture.java` and look for the method `getPixels2D`. Is it there?
   1) Yes.
3) Does the following code compile? `DigitalPicture p = new DigitalPicture();`
   1) No.
4) Assuming that a no-argument constructor exists for `SimplePicture`, would the following code compile?
   `DigitalPicture p = new SimplePicture`
   1) Yes, it would. DigitalPicture implements SimplePicture.
5) Assuming that a no-argument constructor exists for `Picture`, does the following code compile?
   `DigitalPicture p = new Picture();`
   1) Yes, it would. DigitalPicture implements Picture which extends SimplePicture.
6) Assuming that a no-argument constructor exists for `Picture`, does the following code compile?
   `SimplePicture p = new Picture();`
   1) Yes, it would. Picture extends SimplePicture.
7) Assuming that a no=argument constructor exists for `SimplePicture`, does the following code compile?
   `Picture p = new SimplePicture();`
   1) No, it would not. SimplePicture does not use Picture.

## A6
No questions.

## A7
1) How many times would the body of this nested `for` loop execute?
    ```java
    for (int row = 7; row < 17; row ++)
        for (int col = 6; col < 15; col++)
    ```
    1) It would execute ninety times.
2) How many times would the body of this nested `for` loop execute?
    ```java
    for (int row = 7; row < 17; row ++)
        for (int col = 6; col < 15; col++)
    ```
    1) It would execute one hundred and twelve times.

## A8

## A9
