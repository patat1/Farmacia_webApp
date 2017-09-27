package farmacia_webapp

class MainMenuTagLib {
    static defaultEncodeAs = "raw"
    def menuMain = {
        def homeURL
        switch (session.usertype){
            case "TF":
                homeURL = "../homepage/home_TF.gsp"
                break
            case "DF":
                homeURL = "../homepage/home_DF.gsp"
                break
            case "OB":
                homeURL = "../homepage/home_OB.gsp"
                break
            case "REG":
                homeURL = "../homepage/home_REG.gsp"
                break
            default:
                homeURL = "#"
                break
        }
        if (session.usertype=="REG"){
            out << "<div class=\"section\">\n" +
                    "      <div class=\"container\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <ul class=\"nav nav-pills\">\n" +
                    "              <li class=\"active\">\n" +
                    "                <a href=\"" + homeURL + "\">Home</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"../messaggi/inbox.gsp\">Messaggi</a>\n" +
                    "              </li>\n" +
                    "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div"
        }else{
            out << "<div class=\"section\">\n" +
                    "      <div class=\"container\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <ul class=\"nav nav-pills\">\n" +
                    "              <li class=\"active\">\n" +
                    "                <a href=\"" + homeURL + "\">Home</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"../messaggi/inbox.gsp\">Messaggi</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"../carrello/index.gsp\">Carrello</a>\n" +
                    "              </li>\n" +
                    "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div"
        }
    }

    def header = {
        out << "<div class=\"navbar navbar-default navbar-static-top\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <a class=\"navbar-brand\" href=\"/Farmacia_WebApp/\"><span>Farmacie Regionali</span></a>\n" +
                "        </div>\n" +
                "        <g:if test=\"${session.user}\">\n" +
                "            <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\">\n" +
                "                <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                    <li>\n" +
                "                        <a href=\"#\">Accesso come ${session.userinfo}</a>\n" +
                "                    </li>\n" +
                "                    <li class=\"active\">\n" +
                "                        <a controller=\"login\" href=\"../login/logout.gsp\">Logout</a>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </g:if>\n" +
                "    </div>\n" +
                "</div>"
    }
}
