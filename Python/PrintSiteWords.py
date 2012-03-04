# print all visible words from a site

import sys, urllib2, BeautifulSoup, re

if len(sys.argv) != 2:
  print "Usage: PrintSiteWords.py url"
  sys.exit(0)

url = sys.argv[1]

req = urllib2.Request(url, headers={'User-Agent':""})
response = 0
try:
  response = urllib2.urlopen(req)
except:
  print sys.exc_info()[1]
  sys.exit(0)

html = response.read()

soup = BeautifulSoup.BeautifulSoup(html)
texts = soup.findAll(text=True)

def visible(element):
  if element.parent.name in ['style', 'script', '[document]', 'head', 'title']:
    return False
  elif re.match('<!--.*-->', str(element)):
    return False
  return True

visible_texts = filter(visible, texts)
visible_texts = map(lambda s: s.strip(), visible_texts)
reduced_texts = []
for i in visible_texts:
  if i != "":
    pattern = re.compile('[\W_]+')
    words = re.split(pattern,i)
    for j in words:
      if j != "":
        reduced_texts.append(j)

reduced_texts.sort()
for i in reduced_texts:
  print i
