package com.lyncode.xoai.dataprovider.model;

import com.lyncode.xoai.model.oaipmh.About;
import com.lyncode.xoai.model.oaipmh.Metadata;

import java.util.List;

/**
 * This is a required class to extend when implementing a specific OAI Data Provider.
 * It works as a wrapper for all OAI Items.
 *
 * @author Development @ Lyncode
 * @version 3.1.0
 */
public interface Item extends ItemIdentifier {
    /**
     * Most of the implementations would return an empty list.
     * Anyway, the OAI-PMH protocol establishes an abouts section for each item.
     *
     * @return List of information abouts the item (marshable information)
     * @see <a href="client://www.openarchives.org/OAI/openarchivesprotocol.html#Record">Record definition</a>
     */
    List<About> getAbout();

    /**
     * Metadata associated to the OAI-PMH Record.
     *
     * @return Metadata associated to the OAI-PMH Record
     * @see <a href="client://www.openarchives.org/OAI/openarchivesprotocol.html#Record">Record definition</a>
     */
    Metadata getMetadata();
}
