package com.lyncode.xoai.dataprovider.handlers.helpers;

import com.lyncode.xoai.dataprovider.exceptions.CannotDisseminateFormatException;
import com.lyncode.xoai.dataprovider.exceptions.IdDoesNotExistException;
import com.lyncode.xoai.dataprovider.exceptions.OAIException;
import com.lyncode.xoai.dataprovider.filter.Scope;
import com.lyncode.xoai.dataprovider.filter.ScopedFilter;
import com.lyncode.xoai.dataprovider.handlers.results.ListItemIdentifiersResult;
import com.lyncode.xoai.dataprovider.handlers.results.ListItemsResults;
import com.lyncode.xoai.dataprovider.model.Context;
import com.lyncode.xoai.dataprovider.model.Item;
import com.lyncode.xoai.dataprovider.model.MetadataFormat;
import com.lyncode.xoai.dataprovider.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemRepositoryHelper {
    private ItemRepository itemRepository;

    public ItemRepositoryHelper(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix)
            throws CannotDisseminateFormatException, OAIException {
        return itemRepository.getItemIdentifiers(getScopedFilters(context, metadataPrefix), offset, length);
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix, Date from)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItemIdentifiers(filters, offset, length, from);
    }

    private List<ScopedFilter> getScopedFilters(Context context, String metadataPrefix) throws CannotDisseminateFormatException {
        List<ScopedFilter> filters = new ArrayList<ScopedFilter>();
        if (context.hasCondition())
            filters.add(new ScopedFilter(context.getCondition(), Scope.Context));

        MetadataFormat metadataFormat = context.formatForPrefix(metadataPrefix);
        if (metadataFormat.hasCondition())
            filters.add(new ScopedFilter(metadataFormat.getCondition(), Scope.MetadataFormat));
        return filters;
    }

    public ListItemIdentifiersResult getItemIdentifiersUntil(
            Context context, int offset, int length, String metadataPrefix,
            Date until) throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItemIdentifiersUntil(filters, offset, length, until);
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix, Date from, Date until)
            throws CannotDisseminateFormatException, OAIException {
        return itemRepository.getItemIdentifiers(getScopedFilters(context, metadataPrefix), offset, length, from, until);
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix, String setSpec)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItemIdentifiers(filters, offset, length);
        } else
            return itemRepository.getItemIdentifiers(filters, offset, length, setSpec);
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix, String setSpec,
                                                        Date from) throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItemIdentifiers(filters, offset, length, from);
        } else
            return itemRepository.getItemIdentifiers(filters, offset, length, setSpec,
                    from);
    }

    public ListItemIdentifiersResult getItemIdentifiersUntil(
            Context context, int offset, int length, String metadataPrefix,
            String setSpec, Date until) throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItemIdentifiersUntil(filters, offset, length, until);
        } else
            return itemRepository.getItemIdentifiersUntil(filters, offset, length,
                    setSpec, until);
    }

    public ListItemIdentifiersResult getItemIdentifiers(Context context,
                                                        int offset, int length, String metadataPrefix, String setSpec,
                                                        Date from, Date until) throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository
                    .getItemIdentifiers(filters, offset, length, from, until);
        } else
            return itemRepository.getItemIdentifiers(filters, offset, length, setSpec,
                    from, until);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItems(filters, offset, length);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix, Date from)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItems(filters, offset, length, from);
    }

    public ListItemsResults getItemsUntil(Context context, int offset,
                                          int length, String metadataPrefix, Date until)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItemsUntil(filters, offset, length, until);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix, Date from, Date until)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        return itemRepository.getItems(filters, offset, length, from, until);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix, String setSpec)
            throws CannotDisseminateFormatException, OAIException {

        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItems(filters, offset, length);
        } else
            return itemRepository.getItems(filters, offset, length, setSpec);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix, String setSpec, Date from)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItems(filters, offset, length, from);
        } else
            return itemRepository.getItems(filters, offset, length, setSpec, from);
    }

    public ListItemsResults getItemsUntil(Context context, int offset,
                                          int length, String metadataPrefix, String setSpec, Date until)
            throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItemsUntil(filters, offset, length, until);
        } else
            return itemRepository.getItemsUntil(filters, offset, length, setSpec, until);
    }

    public ListItemsResults getItems(Context context, int offset,
                                     int length, String metadataPrefix, String setSpec, Date from,
                                     Date until) throws CannotDisseminateFormatException, OAIException {
        List<ScopedFilter> filters = getScopedFilters(context, metadataPrefix);
        if (context.isStaticSet(setSpec)) {
            filters.add(new ScopedFilter(context.getSet(setSpec).getCondition(), Scope.Set));
            return itemRepository.getItems(filters, offset, length, from, until);
        } else
            return itemRepository.getItems(filters, offset, length, setSpec, from, until);
    }

    public Item getItem(String identifier) throws IdDoesNotExistException, OAIException {
        return itemRepository.getItem(identifier);
    }
}
