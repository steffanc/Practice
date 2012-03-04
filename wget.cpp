#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <netdb.h>
#include <sys/param.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <fstream>
#include <time.h>

using namespace std;

int main(int argc, char** argv) {
  if (argc != 2) {
    cout << "usage: " << argv[0] << " <url>" << endl;
    return 0;
  }
  string hostName = argv[1];
  struct addrinfo hints, *res, *p;
  int status;
  char ipstr[INET6_ADDRSTRLEN];

  memset(&hints, 0, sizeof hints); 
  hints.ai_family = AF_UNSPEC;
  hints.ai_socktype = SOCK_STREAM; 
  hints.ai_flags = AI_PASSIVE;

  if ((status = getaddrinfo(hostName.c_str(), "http", &hints, &res)) != 0) {
    fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(status));
    return 2;
  }

  for (p=res;p!=NULL;p=p->ai_next) {
    void *addr;
    struct sockaddr_in *ipv4 = (struct sockaddr_in *)p->ai_addr;
    addr = &(ipv4->sin_addr);
    
    inet_ntop(p->ai_family, addr, ipstr, sizeof ipstr);
  }
  int sockfd = socket(res->ai_family, res->ai_socktype, res->ai_protocol);
  //bind(sockfd, res->ai_addr, res->ai_addrlen);
  connect(sockfd, res->ai_addr, res->ai_addrlen);
  
  char * page = "/";

  char *query;
  char *getpage = page;
  char *tpl = "GET /%s HTTP/1.0\r\nHost: %s\r\nUser-Agent: %s\r\n\r\n";
  if(getpage[0] == '/') getpage = getpage + 1;
  query = (char *)malloc(strlen(hostName.c_str())+strlen(getpage)+strlen("HTMLGET 1.0")+strlen(tpl)-5);
  sprintf(query, tpl, getpage, hostName.c_str(), "HTMLGET 1.0");
  
  int sent = 0;
  int tmpres = 0;
  while(sent < strlen(query)) {
    tmpres = send(sockfd, query+sent, strlen(query)-sent, 0);
    if(tmpres == -1){
      perror("Can't send query");
      exit(1);
    }
    sent += tmpres;
  }

  char buf[BUFSIZ+1];
  memset(buf, 0, sizeof(buf));
  int htmlstart = 0;
  char * htmlcontent;

  while((tmpres = recv(sockfd, buf, BUFSIZ, 0)) > 0) {
    if(htmlstart == 0) {
      htmlcontent = strstr(buf, "\r\n\r\n");
      if(htmlcontent != NULL){
        htmlstart = 1;
        htmlcontent += 4;
      }
    }else{
      htmlcontent = buf;
    }
    if(htmlstart){
      cout << htmlcontent << endl;
    }
    memset(buf, 0, tmpres);
  }
  
  free(query);
  freeaddrinfo(res);
  close(sockfd);
  return 0;
}
