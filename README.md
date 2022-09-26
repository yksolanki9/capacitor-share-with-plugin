# share-with

This plugin enables you to share images and pdfs with your capacitor app

## Install

```bash
npm install share-with
npx cap sync
```

## API

<docgen-index>

- [share-with](#share-with)
  - [Install](#install)
  - [API](#api)
    - [addListener('FILE_SINGLE', ...)](#addlistenerfile_single-)
    - [Interfaces](#interfaces)
      - [PluginListenerHandle](#pluginlistenerhandle)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### addListener('FILE_SINGLE', ...)

```typescript
addListener(eventName: 'FILE_SINGLE', listenerFunc: (event: any) => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                 | Description                                           |
| ------------------ | ------------------------------------ | ----------------------------------------------------- |
| **`eventName`**    | <code>'FILE_SINGLE'</code>           | - Name of the event to listen to                      |
| **`listenerFunc`** | <code>(event: any) =&gt; void</code> | - The callback that is executed when the event occurs |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
