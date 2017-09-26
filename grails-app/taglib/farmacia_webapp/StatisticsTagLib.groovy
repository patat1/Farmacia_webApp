package farmacia_webapp

import java.text.DateFormat
import java.text.SimpleDateFormat

class StatisticsTagLib {
    static defaultEncodeAs = "raw"

    def statisticTable = {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd")
//        Date start = format.parse(params.start)
//        Date end = format.parse(params.end)
        int totaleAcquisti = 0, prodottiInScontrino = 0, farmaciConRicetta = 0, totaleRicette = 0, mediaProdottiPerRicetta = 0
        def queryOutput
        if (session.usertype=="REG")
            totaleAcquisti = Acquisto.executeQuery("from Acquisto as aq where aq.data>= ? and aq.data<= ?", [params.start, params.end]).size()
        else
            totaleAcquisti = Acquisto.executeQuery("from Acquisto as aq, Utente as ut where ut.idFarmacia = ? and aq.idUtente=ut.id and aq.data>= ? and aq.data<= ?", [session.farmacia, params.start, params.end]).size()
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/invoice.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Acquisti complessivi</h4>\n" +
                "                            <p>" + totaleAcquisti + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            queryOutput = InScontrino.executeQuery("select sc.quantità from InScontrino as sc, Acquisto as aq where sc.idAcquisto=aq.id and aq.data>= ? and aq.data<= ?", [params.start, params.end])
        else{
            queryOutput = InScontrino.executeQuery("select scon.quantità from InScontrino as scon, Utente as ut, Acquisto as aq where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and aq.data>= ? and aq.data<= ?", [session.farmacia, params.start, params.end])
        }
        if (queryOutput.size()>0)
            for (int i=0; i<queryOutput.size(); i++)
                prodottiInScontrino += queryOutput.getAt(i)
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/pills.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Farmaci venduti in totale</h4>\n" +
                "                            <p>" + prodottiInScontrino + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            farmaciConRicetta = InScontrino.executeQuery("from InScontrino as scon, Acquisto as aq, Ricetta as rc where scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ? group by scon.idProdotto", [params.start, params.end]).size()
        else{
            farmaciConRicetta = InScontrino.executeQuery("from InScontrino as scon, Utente as ut, Acquisto as aq, Ricetta as rc where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ? group by scon.idProdotto", [session.farmacia, params.start, params.end]).size()
        }
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/doctor.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Farmaci con ricetta</h4>\n" +
                "                            <p>" + farmaciConRicetta + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            totaleRicette = InScontrino.executeQuery("from InScontrino as scon, Acquisto as aq, Ricetta as rc where scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ? group by rc.codiceRicetta", [params.start, params.end]).size()
        else{
            totaleRicette = InScontrino.executeQuery("from InScontrino as scon, Utente as ut, Acquisto as aq, Ricetta as rc where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ? group by rc.codiceRicetta", [session.farmacia, params.start, params.end]).size()
        }
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/stethoscope.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Ricette totali</h4>\n" +
                "                            <p>" + totaleRicette + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            queryOutput = InScontrino.executeQuery("select scon.quantità from InScontrino as scon, Acquisto as aq, Ricetta as rc where scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ?", [params.start, params.end])
        else{
            queryOutput = InScontrino.executeQuery("select scon.quantità from InScontrino as scon, Utente as ut, Acquisto as aq, Ricetta as rc where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and scon.id=rc.idScontrino and aq.data>= ? and aq.data<= ?", [session.farmacia, params.start, params.end])
        }
        int totaleProdotti_Ricetta = 0
        if (queryOutput.size()>0)
            for (int i=0; i<queryOutput.size(); i++)
                totaleProdotti_Ricetta += queryOutput.getAt(i)
        if (totaleRicette!=0)
            mediaProdottiPerRicetta = totaleProdotti_Ricetta/totaleRicette
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/media.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Numero medio di farmaci per ricetta</h4>\n" +
                "                            <p>" + mediaProdottiPerRicetta + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
    }
}
