import cv2

video = cv2.VideoCapture(0)
a = 0
face_cascade = cv2.CascadeClassifier(r".\haarcascade_frontalface_default.xml")
smile_cascade = cv2.CascadeClassifier(r".\haarcascade_smile.xml")

state = str("default") # Initiate a default state at first
while True: #Everything will be contained inside of this loop either way, will be cluttered
    if state == "default":
        _, frame = video.read()
        color = frame
        img = color
        cv2.putText(img, 'Mode: Default', (5, 20), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (255, 255, 255), 0)



    if state == "face":
        _, frame = video.read()
        color = frame
        img = color
        cv2.putText(img, 'Mode: Face', (5, 20), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (255, 255, 255), 0)
        faces = face_cascade.detectMultiScale(color, scaleFactor=1.05, minNeighbors=5)
        if faces == ():
            cv2.putText(img, 'Faces: 0', (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            img = img
        elif faces != ():
            cv2.putText(img, 'Faces: {}'.format(len(faces)), (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            for x, y, w, h in faces:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 255, 0), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 60, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Face', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 255, 0), 0)




    if state == "smile":
        _, frame = video.read()
        color = frame
        img = color
        cv2.putText(img, 'Mode: Smile', (5, 20), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (255, 255, 255), 0)
        smile = smile_cascade.detectMultiScale(color, scaleFactor=1.65, minNeighbors=20)
        if smile == ():
            img = color
            cv2.putText(img, 'Smiles: 0', (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
        elif smile != ():
            cv2.putText(img, 'Smiles: {}'.format(len(smile)), (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            for x, y, w, h in smile:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 255, 0), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 68, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Smile', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 255, 0), 0)



    if state == "all":
        _, frame = video.read()
        color = frame
        img = color
        cv2.putText(img, 'Mode: Faces and Smiles', (5, 20), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (255, 255, 255), 0)
        smile = smile_cascade.detectMultiScale(color, scaleFactor=1.65, minNeighbors=20)
        faces = face_cascade.detectMultiScale(color, scaleFactor=1.05, minNeighbors=5)
        if faces == () and smile == ():
            img = color
            cv2.putText(img, 'Faces: 0', (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            cv2.putText(img, 'Smiles: 0', (5, 60), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
        elif faces != () and smile == ():
            cv2.putText(img, 'Faces: {}'.format(len(faces)), (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            cv2.putText(img, 'Smiles: 0'.format(len(smile)), (5, 60), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            for x, y, w, h in faces:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 255, 0), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 60, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Face', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 255, 0), 0)
        elif faces == () and smile != ():
            cv2.putText(img, 'Faces: 0', (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            cv2.putText(img, 'Smiles: {}'.format(len(smile)), (5, 60), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            for x, y, w, h in smile:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 0, 255), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 68, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Smile', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 0, 255), 0)
        elif faces != () and smile != ():
            cv2.putText(img, 'Faces: {}'.format(len(faces)), (5, 40), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            cv2.putText(img, 'Smiles: {}'.format(len(smile)), (5, 60), cv2.FONT_HERSHEY_TRIPLEX, 0.5, (255, 255, 255), 0)
            for x, y, w, h in faces:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 255, 0), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 60, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Face', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 255, 0), 0)
            for x, y, w, h in smile:
                img = cv2.rectangle(color, (x, y), (x + w, y + h), (0, 0, 255), 3)
                img = cv2.rectangle(color, (x - 2, y - 30), (x + 68, y - 1), (250, 250, 250), -1)
                cv2.putText(img, 'Smile', (x, y - 10), cv2.FONT_HERSHEY_TRIPLEX, 0.7, (0, 0, 255), 0)


    # List controls
    cv2.putText(img, 'Controls:', (550, 75), cv2.FONT_HERSHEY_TRIPLEX, 0.4, (255, 255, 255), 0)
    cv2.putText(img, 'f : face', (550, 90), cv2.FONT_HERSHEY_TRIPLEX, 0.4, (255, 255, 255), 0)
    cv2.putText(img, 'd : default', (550, 105), cv2.FONT_HERSHEY_TRIPLEX, 0.4, (255, 255, 255), 0)
    cv2.putText(img, 's : smile', (550, 120), cv2.FONT_HERSHEY_TRIPLEX, 0.4, (255, 255, 255), 0)
    cv2.putText(img, 'a : all', (550, 135), cv2.FONT_HERSHEY_TRIPLEX, 0.4, (255, 255, 255), 0)

    cv2.imshow("Capture", img)
    key = cv2.waitKey(1)
    if key == ord("d"):
        state = "default"
    if key == ord("f"):
        state = "face"
    if key == ord("s"):
        state = "smile"
    if key == ord("a"):
        state = "all"
    if key == ord("q"):
        break

print(a) # Number of recorder frames
video.release()
cv2.destroyAllWindows()
