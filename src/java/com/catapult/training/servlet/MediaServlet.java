package com.catapult.training.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@WebServlet("/media")
public class MediaServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Color canvasColor = Color.WHITE;
        Color smileyBg = Color.YELLOW;
        Color strokeColor = Color.BLACK;

        if (req.getParameter("canvas") != null) {
            canvasColor = Color.decode("#" + req.getParameter("canvas"));
        }
        
        if (req.getParameter("smiley") != null) {
            smileyBg = Color.decode("#" + req.getParameter("smiley"));
        }

        if (req.getParameter("stroke") != null) {
            strokeColor = Color.decode("#" + req.getParameter("stroke"));
        }

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(canvasColor);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

        int centerX = image.getWidth() / 2;
        int centerY = image.getHeight() / 2;

        g.setColor(smileyBg);
        g.fillArc(centerX - 40, centerY - 40, 80, 80, 0, 360);

        g.setColor(strokeColor);
        g.drawArc(centerX - 40, centerY - 40, 80, 80, 0, 360);
        g.fillArc(centerX - 20, centerY - 20, 5, 5, 0, 360);
        g.fillArc(centerX + 15, centerY - 20, 5, 5, 0, 360);
        g.drawArc(centerX - 25, centerY, 50, 20, 0, -180);

        resp.setContentType("image/png");
        ImageIO.write(image, "png", resp.getOutputStream());
    }

}
