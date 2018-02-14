import nltk

def getPosTags(command):
    command = nltk.tokenize.word_tokenize("I " + command)
    return nltk.pos_tag(command)

commands = [
    "walk to the door",
    "walk to door",
    "run to the wall",
    "crawl toward the cave",
    "jump toward the window",
    "head to the kitchen",
    "mosey toward the tall, pale man",
    "mosey toward the tall pale man",
    "sprint at the blue goblin"
 ]

for command in commands:
    print(getPosTags(command))
