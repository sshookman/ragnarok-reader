import nltk

def getPosTags(command):
    command = nltk.tokenize.word_tokenize("I " + command)
    return nltk.pos_tag(command)

print(getPosTags("walk to the door"))
